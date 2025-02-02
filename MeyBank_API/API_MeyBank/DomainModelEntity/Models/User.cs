﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DomainModelEntity.Models
{
	public class User
	{
		public int UserID { get; set; }
		public string? FullName { get; set; }
		public string? IMG { get; set; }
		public string? NRIC { get; set; }
		public int Age { get; set; }
		public string? BirthDate { get; set; }
		public string? Gender { get; set; }
		public string? Email { get; set; }
		public bool Active { get; set; }
	}
}
