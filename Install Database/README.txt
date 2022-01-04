DETAIL INSTALL INSTRUCTIONS

- The game using SQLite3 as database to minimize the game's size and and simplify game installation: 

+ JDBC:
	1. Download new JDBC file version 3.34: https://jar-download.com/artifacts/org.xerial/sqlite-jdbc/3.34.0/source-code

	or
	
	2. Use the attached JDBC file in folder: '../Dodge Game/lib/sqlite-jdbc-3.34.0.jar'
	
*Remember to add JDBC to project

+ Database:
	1. Create new Database:
	- Open sqlite3 with CMD and run queries from 'queries.txt' file
	- Change the path to database file in congif file: DB_URL=jdbc:sqlite:DATABASE_PATH / DATABASE_NAME.db
		
	or
	
	2. Use the attached Database file in folder: '../Dodge Game/SQL lite/mydatabase.db'
	- Change the path to database file in congif file: DB_URL=jdbc:sqlite:..YOUR_PATH../Dodge Game/SQL lite/mydatabase.db
