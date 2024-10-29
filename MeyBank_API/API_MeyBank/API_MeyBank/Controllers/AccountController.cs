using Contracts;
using DomainModelEntity.Models;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace API_MeyBank.Controllers
{
	[Route("api/[controller]")]
	[ApiController]
	[Authorize]
	public class AccountController : ControllerBase
	{
		private IRepositoryWrapper _repoWrapper;
		public AccountController(IRepositoryWrapper repoWrapper)
		{
			_repoWrapper = repoWrapper;
		}

		[HttpGet]
		public IEnumerable<Account> GetAllAccount()
		{
			return _repoWrapper.Account.FindAll();
		}

		[HttpGet("{id}")]
		public async Task<ActionResult<Account>> GetAccount(int id)
		{
			var account = await _repoWrapper.Account.FindByCondition(e => e.AccountID == id).FirstOrDefaultAsync();
			if (account == null)
			{
				return NotFound();
			}
			return account;
		}

		[HttpPut("{id}")]
		public IActionResult PutAccount(int id, Account account)
		{
			if (id != account.AccountID)
			{
				return BadRequest();
			}

			_repoWrapper.Account.Update(account);

			try
			{
				_repoWrapper.Save();
			}
			catch (DbUpdateConcurrencyException)
			{
				if (!AccountExists(id))
				{
					return NotFound();
				}
				else
				{
					throw;
				}
			}
			return NoContent();
		}

		[HttpPost]
		public ActionResult<Account> PostAccount(Account account)
		{
			_repoWrapper.Account.Create(account);
			_repoWrapper.Save();
			return CreatedAtAction("GetAccount", new { id = account.AccountID }, account);
		}

		[HttpDelete("{id}")]
		public async Task<IActionResult> DeleteAccount(int id)
		{
			var account = await _repoWrapper.Account.FindByCondition(e => e.AccountID == id).FirstOrDefaultAsync();
			if (account == null)
			{
				return NotFound();
			}
			_repoWrapper.Account.Delete(account);
			_repoWrapper.Save();
			return NoContent();
		}

		private bool AccountExists(int id)
		{
			return _repoWrapper.Account.FindByCondition(e => e.AccountID == id).Any(e => e.AccountID == id);
		}
	}
}
