using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Contracts
{
	public interface IRepositoryWrapper
	{
		IAccount Account { get; }
		IBankAccount BankAccount { get; }
		IAdmin Admin { get; }
		IUser User { get; }
		ITransaction Transaction { get; }
		IContact Contact { get; }
		void Save();
	}
}
