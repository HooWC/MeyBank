using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Contracts;
using DomainModelEntity.Models;

namespace Insfrastructure.Repository
{
	public class BankAccountRepository : RepositoryBase<BankAccount>, IBankAccount
	{
		public BankAccountRepository(AppDbContext appDbContext) : base(appDbContext)
		{

		}
	}
}
