using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace Insfrastructure.Migrations
{
    public partial class add6 : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.RenameColumn(
                name: "S",
                table: "Transactions",
                newName: "OtherDescription");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.RenameColumn(
                name: "OtherDescription",
                table: "Transactions",
                newName: "S");
        }
    }
}
