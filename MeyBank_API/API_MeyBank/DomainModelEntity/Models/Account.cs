using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DomainModelEntity.Models
{
	public class Account
	{
		public int AccountID { get; set; }
		public int UserID { get; set; }
		public string? Username { get; set; }
		public string? Password { get; set; }
		public string? AccountStatus { get; set; }
		public int LoginLimit { get; set; }
		public string? VerifyWord { get; set; }
		public string? BankType { get; set; }
		public string? LoginTime { get; set; }
	}
}
