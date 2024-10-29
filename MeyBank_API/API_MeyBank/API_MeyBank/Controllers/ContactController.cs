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
	public class ContactController : ControllerBase
	{
		private IRepositoryWrapper _repoWrapper;
		public ContactController(IRepositoryWrapper repoWrapper)
		{
			_repoWrapper = repoWrapper;
		}

		[HttpGet]
		public IEnumerable<Contact> GetAllContact()
		{
			return _repoWrapper.Contact.FindAll();
		}

		[HttpGet("{id}")]
		public async Task<ActionResult<Contact>> GetContact(int id)
		{
			var tr = await _repoWrapper.Contact.FindByCondition(e => e.ContactID == id).FirstOrDefaultAsync();
			if (tr == null)
			{
				return NotFound();
			}
			return tr;
		}

		[HttpPut("{id}")]
		public IActionResult PutContact(int id, Contact con)
		{
			if (id != con.ContactID)
			{
				return BadRequest();
			}

			_repoWrapper.Contact.Update(con);

			try
			{
				_repoWrapper.Save();
			}
			catch (DbUpdateConcurrencyException)
			{
				if (!ContactExists(id))
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
		public ActionResult<Contact> PostContact(Contact con)
		{
			_repoWrapper.Contact.Create(con);
			_repoWrapper.Save();
			return CreatedAtAction("GetContact", new { id = con.ContactID }, con);
		}

		[HttpDelete("{id}")]
		public async Task<IActionResult> DeleteContact(int id)
		{
			var con = await _repoWrapper.Contact.FindByCondition(e => e.ContactID == id).FirstOrDefaultAsync();
			if (con == null)
			{
				return NotFound();
			}
			_repoWrapper.Contact.Delete(con);
			_repoWrapper.Save();
			return NoContent();
		}

		private bool ContactExists(int id)
		{
			return _repoWrapper.Contact.FindByCondition(e => e.ContactID == id).Any(e => e.ContactID == id);
		}
	}
}
