# Home Secure Technical Test

A submission task of Home secure backend developer candidate exercise. 
The service reads from a given CSV file line by line, each line represent a device. 
The service call a resp api to get additional data on each device, merge the additional data with data read from the input file, 
and writes it all to a new file. 


## Installation Instructions 

* install SQLite DB
* run from command line:
```console
> .open 'Home_Secure.db'
> CREATE TABLE "Devices" (
	"user_agent"	TEXT NOT NULL UNIQUE,
	"is_mobile_device"	TEXT,
	"type"	TEXT,
	"brand"	TEXT,
	"brand_code"	TEXT,
	"brand_url"	TEXT,
	"name"	TEXT,
	PRIMARY KEY("user_agent")
);
``` 

## Running 

```console
> sbt "run <input file path> <access key> <output file path>"
```

## Improvement Suggestions

* Add unit tests
* Add integration tests
* Add configuration
* Add logs
* Change Await with async lock or change to a synchronous rest api call
 

## Thank you for your time on reviewing this submission


