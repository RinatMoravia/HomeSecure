I userd slqlite DB so u need to install sqlite and run the script from command line:
.open 'Home_Secure.db'
CREATE TABLE "Devices" (
	"user_agent"	TEXT NOT NULL UNIQUE,
	"is_mobile_device"	TEXT,
	"type"	TEXT,
	"brand"	TEXT,
	"brand_code"	TEXT,
	"brand_url"	TEXT,
	"name"	TEXT,
	PRIMARY KEY("user_agent")
);


In order to rum the program u need to give 3 parameters:
sbt "run <input file path> <access key> <output file path>"
example:
sbt "run /Users/rinatmoravia/devices.csv 12827733d77e0e6e5f54115a34e49da3 /Users/rinatmoravia/devicesoutput.csv"
