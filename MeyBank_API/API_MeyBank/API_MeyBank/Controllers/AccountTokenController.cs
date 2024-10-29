﻿using Contracts;
using DomainModelEntity.Models;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;
using Microsoft.AspNetCore.Mvc;
using Microsoft.IdentityModel.Tokens;
using Microsoft.EntityFrameworkCore;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace API_MeyBank.Controllers
{
	[Route("api/[controller]")]
	[ApiController]
	public class AccountTokenController : ControllerBase
	{
		private IRepositoryWrapper _repoWrapper;
		private IConfiguration _configuration;
		public AccountTokenController(IConfiguration configuration, IRepositoryWrapper repoWrapper)
		{
			_configuration = configuration;
			_repoWrapper = repoWrapper;
		}

		[HttpPost]
		public async Task<IActionResult> Post(Account userInfo)
		{
			if (userInfo != null && userInfo.Username != null && userInfo.Password != null)
			{
				//Member
				var user = await GetAccount(userInfo.Username, userInfo.Password);

				if (user.Value != null)
				{
					var claim = new[] {
					new Claim(JwtRegisteredClaimNames.Sub,_configuration["Jwt:Subject"]),
					new Claim(JwtRegisteredClaimNames.Jti,Guid.NewGuid().ToString()),
					new Claim(JwtRegisteredClaimNames.Iat,DateTime.UtcNow.ToString()),
					new Claim("Id",user.Value.AccountID.ToString()),
					new Claim("Username",user.Value.Username),
					new Claim("Password",user.Value.Password)
					};
					var key = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(_configuration["Jwt:Key"]));
					var signIn = new SigningCredentials(key, SecurityAlgorithms.HmacSha256);
					var token = new JwtSecurityToken(
						_configuration["Jwt:Issuer"],
						_configuration["Jwt:Audience"],
						claim,
						expires: DateTime.Now.AddMinutes(20),
						signingCredentials: signIn
						);
					return Ok(new JwtSecurityTokenHandler().WriteToken(token));
				}
				else
				{
					return BadRequest("Invalid credentials");
				}
			}
			else
			{
				return BadRequest();
			}
		}

		[HttpGet]
		public async Task<ActionResult<Account>> GetAccount(string Username, string Password)
		{
			return await _repoWrapper.Account.FindByCondition(e => e.Username == Username && e.Password == Password).FirstOrDefaultAsync();
		}
	}
}