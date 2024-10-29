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
	public class AdminController : ControllerBase
	{
		private IRepositoryWrapper _repoWrapper;
		public AdminController(IRepositoryWrapper repoWrapper)
		{
			_repoWrapper = repoWrapper;
		}

		[HttpGet]
		public IEnumerable<Admin> GetAllAdmin()
		{
			return _repoWrapper.Admin.FindAll();
		}

		[HttpGet("{id}")]
		public async Task<ActionResult<Admin>> GetAdmin(int id)
		{
			var admin = await _repoWrapper.Admin.FindByCondition(e => e.AdminID == id).FirstOrDefaultAsync();
			if (admin == null)
			{
				return NotFound();
			}
			return admin;
		}

		[HttpPut("{id}")]
		public IActionResult PutAdmin(int id, Admin admin)
		{
			if (id != admin.AdminID)
			{
				return BadRequest();
			}

			_repoWrapper.Admin.Update(admin);

			try
			{
				_repoWrapper.Save();
			}
			catch (DbUpdateConcurrencyException)
			{
				if (!AdminExists(id))
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
		public ActionResult<Account> PostAdmin(Admin admin)
		{
			_repoWrapper.Admin.Create(admin);
			_repoWrapper.Save();
			return CreatedAtAction("GetAdmin", new { id = admin.AdminID }, admin);
		}

		[HttpDelete("{id}")]
		public async Task<IActionResult> DeleteAdmin(int id)
		{
			var admin = await _repoWrapper.Admin.FindByCondition(e => e.AdminID == id).FirstOrDefaultAsync();
			if (admin == null)
			{
				return NotFound();
			}
			_repoWrapper.Admin.Delete(admin);
			_repoWrapper.Save();
			return NoContent();
		}

		private bool AdminExists(int id)
		{
			return _repoWrapper.Admin.FindByCondition(e => e.AdminID == id).Any(e => e.AdminID == id);
		}

	}
}
