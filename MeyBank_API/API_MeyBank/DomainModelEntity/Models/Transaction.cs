using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DomainModelEntity.Models
{
	public class Transaction
	{
		public int TransactionID { get; set; }
		public int BankAccountID { get; set; }
		public string? TransactionType { get; set; }
		public string? TransactionStatus { get; set; }
		public string? Date { get; set; }
		public string? Description { get; set; }
		public string? Credit { get; set; }
		public string? Debit { get; set; }
		public double Amount { get; set; }
		public bool IsIBG { get; set; }
		public double SMSNotification { get; set; }//0.20
		public string? PhoneNumber { get; set; }
		public string? Email { get; set; }
		public string? OtherDescription { get; set; }

	}
}
