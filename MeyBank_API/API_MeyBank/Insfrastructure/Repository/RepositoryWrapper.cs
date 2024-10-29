using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Contracts;
using Microsoft.EntityFrameworkCore.Metadata;

namespace Insfrastructure.Repository
{
	public class RepositoryWrapper : IRepositoryWrapper
	{
		private AppDbContext DB;

		public RepositoryWrapper(AppDbContext _db)
		{
			DB = _db;
		}

		private IAccount _account;
		private IAdmin _admin;
		private IBankAccount _bankaccont;
		private IUser _user;
		private ITransaction _transaction;
		private IContact _contact;

		public IAccount Account
		{
			get
			{
				if (_account == null)
				{
					_account = new AccountRepository(DB);
				}
				return _account;
			}
		}

		public IAdmin Admin
		{
			get
			{
				if (_admin == null)
				{
					_admin = new AdminRepository(DB);
				}
				return _admin;
			}
		}

		public IBankAccount BankAccount
		{
			get
			{
				if (_bankaccont == null)
				{
					_bankaccont = new BankAccountRepository(DB);
				}
				return _bankaccont;
			}
		}

		public IUser User
		{
			get
			{
				if (_user == null)
				{
					_user = new UserRepository(DB);
				}
				return _user;
			}
		}

		public ITransaction Transaction
		{
			get
			{
				if (_transaction == null)
				{
					_transaction = new TransactionRepository(DB);
				}
				return _transaction;
			}
		}

		public IContact Contact
		{
			get
			{
				if (_contact == null)
				{
					_contact = new ContactRepository(DB);
				}
				return _contact;
			}
		}

		public void Save()
		{
			DB.SaveChanges();
		}

	}
}
