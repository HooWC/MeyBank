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
	public class UserController : ControllerBase
	{
		private IRepositoryWrapper _repoWrapper;
		public UserController(IRepositoryWrapper repoWrapper)
		{
			_repoWrapper = repoWrapper;
		}

		[HttpGet]
		public IEnumerable<User> GetAllUser()
		{
			return _repoWrapper.User.FindAll();
		}

		[HttpGet("{id}")]
		public async Task<ActionResult<User>> GetUser(int id)
		{
			var customer = await _repoWrapper.User.FindByCondition(e => e.UserID == id).FirstOrDefaultAsync();
			if (customer == null)
			{
				return NotFound();
			}
			return customer;
		}

		[HttpPut("{id}")]
		public IActionResult PutUser(int id, User cus)
		{
			if (id != cus.UserID)
			{
				return BadRequest();
			}

			_repoWrapper.User.Update(cus);

			try
			{
				_repoWrapper.Save();
			}
			catch (DbUpdateConcurrencyException)
			{
				if (!UserExists(id))
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
		public ActionResult<User> PostUser(User cus)
		{
			_repoWrapper.User.Create(cus);
			_repoWrapper.Save();
			return CreatedAtAction("GetUser", new { id = cus.UserID }, cus);
		}

		[HttpDelete("{id}")]
		public async Task<IActionResult> DeleteUser(int id)
		{
			var cus = await _repoWrapper.User.FindByCondition(e => e.UserID == id).FirstOrDefaultAsync();
			if (cus == null)
			{
				return NotFound();
			}
			_repoWrapper.User.Delete(cus);
			_repoWrapper.Save();
			return NoContent();
		}

		private bool UserExists(int id)
		{
			return _repoWrapper.User.FindByCondition(e => e.UserID == id).Any(e => e.UserID == id);
		}
	}
}
