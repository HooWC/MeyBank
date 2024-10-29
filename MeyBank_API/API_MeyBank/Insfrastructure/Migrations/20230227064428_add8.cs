using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace Insfrastructure.Migrations
{
	public partial class add8 : Migration
	{
		protected override void Up(MigrationBuilder migrationBuilder)
		{
			migrationBuilder.AddColumn<double>(
				name: "AllLimit",
				table: "BankAccounts",
				type: "float",
				nullable: false,
				defaultValue: 0.0);
		}

		protected override void Down(MigrationBuilder migrationBuilder)
		{
			migrationBuilder.DropColumn(
				name: "AllLimit",
				table: "BankAccounts");
		}
	}
}
