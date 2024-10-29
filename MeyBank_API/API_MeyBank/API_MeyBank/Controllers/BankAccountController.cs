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
	public class BankAccountController : ControllerBase
	{
		private IRepositoryWrapper _repoWrapper;
		public BankAccountController(IRepositoryWrapper repoWrapper)
		{
			_repoWrapper = repoWrapper;
		}

		[HttpGet]
		public IEnumerable<BankAccount> GetAllBankAccount()
		{
			return _repoWrapper.BankAccount.FindAll();
		}

		[HttpGet("{id}")]
		public async Task<ActionResult<BankAccount>> GetBankAccount(int id)
		{
			var bankAccountID = await _repoWrapper.BankAccount.FindByCondition(e => e.BankAccountID == id).FirstOrDefaultAsync();
			if (bankAccountID == null)
			{
				return NotFound();
			}
			return bankAccountID;
		}

		[HttpPut("{id}")]
		public IActionResult PutBankAccount(int id, BankAccount bank)
		{
			if (id != bank.BankAccountID)
			{
				return BadRequest();
			}

			_repoWrapper.BankAccount.Update(bank);

			try
			{
				_repoWrapper.Save();
			}
			catch (DbUpdateConcurrencyException)
			{
				if (!BankAccountExists(id))
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
		public ActionResult<BankAccount> PostBankAccount(BankAccount bank)
		{
			_repoWrapper.BankAccount.Create(bank);
			_repoWrapper.Save();
			return CreatedAtAction("GetBankAccount", new { id = bank.BankAccountID }, bank);
		}

		[HttpDelete("{id}")]
		public async Task<IActionResult> DeleteBankAccount(int id)
		{
			var bank = await _repoWrapper.BankAccount.FindByCondition(e => e.BankAccountID == id).FirstOrDefaultAsync();
			if (bank == null)
			{
				return NotFound();
			}
			_repoWrapper.BankAccount.Delete(bank);
			_repoWrapper.Save();
			return NoContent();
		}

		private bool BankAccountExists(int id)
		{
			return _repoWrapper.BankAccount.FindByCondition(e => e.BankAccountID == id).Any(e => e.BankAccountID == id);
		}

	}
}
