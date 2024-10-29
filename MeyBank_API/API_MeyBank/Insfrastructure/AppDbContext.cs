using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DomainModelEntity.Models;
using Microsoft.EntityFrameworkCore;

namespace Insfrastructure
{
	public class AppDbContext : DbContext
	{
		public AppDbContext()
		{

		}

		public AppDbContext(DbContextOptions options) : base(options)
		{
		}

		public DbSet<Account> Accounts { get; set; } = null!;
		public DbSet<Admin> Admins { get; set; } = null!;
		public DbSet<User> Users { get; set; } = null!;
		public DbSet<Contact> Contacts { get; set; } = null!;
		public DbSet<Transaction> Transactions { get; set; } = null!;
		public DbSet<BankAccount> BankAccounts { get; set; } = null!;


		protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
		{
			if (!optionsBuilder.IsConfigured)
			{
				optionsBuilder.UseSqlServer("Server=LAPTOP-75SCS0RS\\SQLEXPRESS;Database=MeyBank;Trusted_Connection=True;TrustServerCertificate=true");
			}
		}
	}
}
