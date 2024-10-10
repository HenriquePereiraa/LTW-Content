LTW - Life on Two Wheels

- Docker to set up database
   - ` docker run -it --name ltw_db -p 3306:3306 -e MYSQL_ROOT_PASSWORD= -e MYSQL_DATABASE=lportal -e MYSQL_ALLOW_EMPTY_PASSWORD=yes mysql:5.7 --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci`

   - Execute the following command to copy the dump to the database.
        - `mysql -u root lportal < ltw_db.sql`
    - link to drive to download the dump:
        - https://drive.google.com/drive/folders/1Q47G3cLG-6KHlKdT6ZvzXV-92jFFXREz?usp=drive_link 

- Java version: `java 11`
- Use the following command to start up the portal:
    - `blade server run`

---
- Known issues
    - When you add a new content it's necessary reindex the portal.
    - The management toolbar search, filter and sort don't works, yet!

---
- As soon, the taglib FDS classic and headles will be implemented