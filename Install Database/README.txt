******************GHI CHÚ******************
Game sử dụng cơ sở dữ liệu sqlite3 nhằm giảm nhẹ dung lượng và trách sự phức tạp nên cần liên kết với JDBC và thay đổi các đường dẫn Url:

(1) JDBC
	C1: Tải JDBC mới bản 3.34
	=> Link tải phiên bản 3.34: https://jar-download.com/artifacts/org.xerial/sqlite-jdbc/3.34.0/source-code

	C2: Sử dụng JDBC có sẵn đính kèm trong folder
	- Link folder: ../Dodge Game/lib/sqlite-jdbc-3.34.0.jar1 và đổi đuổi trở lại thành .jar
	- Thêm lại JDBC vào project bằng cách: File -> Project Structure -> Libaries -> dấu + -> Java -> chọn file JDBC -> OK

(2) Database
	C1: Tạo mới database
	- Sử dụng sqlite đã được tải sẵn trong folder "sqlite" trong "Install Database"
	- Thêm đường dẫn tới folder sqlite đó vào ĐƯỜNG DẪN enviroment variable để có thể sử dụng trong cmd
	- Mở cửa sổ cmd tại nơi muốn tại database và gõ "sqlite3" để truy cập vào sqlite 
	- Chạy các lệnh query trong file query.sql để tạo cơ sở dữ liệu
	- Thay đổi đường dẫn tới file database trong file config.properties: DB_URL=jdbc:sqlite:DATABASE_PATH / DATABASE_NAME.db
	
	C2: Dùng database tạo sẵn đính kém trong folder
	- Link database: .../Dodge Game/SQL lite/mydatabase.db
	- Thay đổi đường dẫn tới file database trong file config.properties: DB_URL=jdbc:sqlite:..YOUR_PATH../Dodge Game/SQL lite/mydatabase.db

