using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DomainModelEntity.Models
{
	public class BankAccount
	{
		public int BankAccountID { get; set; }
		public int AccountID { get; set; }
		public string? AccountType { get; set; }
		public string? BankAccNo { get; set; }
		public string? CardNumber { get; set; }
		public int PinNumber { get; set; }
		public double Balance { get; set; }
		public double CardLimit { get; set; }
		public int BankAcStatus { get; set; }
		public double AllLimit { get; set; }
		public bool Change { get; set; }

	}
}
