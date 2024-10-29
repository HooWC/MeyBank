using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DomainModelEntity.Models
{
	public class Contact
	{
		public int ContactID { get; set; }
		public string? FullName { get; set; }
		public string? Email { get; set; }
		public string? Phone { get; set; }
		public string? NRIC { get; set; }
		public string? Content { get; set; }
		public bool Handle { get; set; }
	}
}
