## sqlite database
### what i was trying to do:
```
char *select_stmt_sql = "SELECT COUNT(*) FROM READINGS";
        sqlite3_stmt*select_stmt;
        sqlite3_prepare_v2(db, select_stmt_sql, -1, &select_stmt, 0);
        sqlite3_step(select_stmt);
        total_rows_no = sqlite3_column_int64(select_stmt,0);
        //must finalize to prevent database locking
        if(total_rows_no>no_of_rows_to_keep)
        {
                //read from sqlite local db
                //SELECT * FROM READINGS ORDER BY ROWID ASC LIMIT 1
                char *select_last_row_sql = "SELECT * FROM READINGS WHERE ROWI>
                sqlite3_stmt* stmt;
                sqlite3_prepare_v2(db,select_last_row_sql, -1, &stmt, 0);
                sqlite3_bind_int64(stmt, 1,total_rows_no-no_of_rows_to_keep);
                //get last (total_rows_no - no_of_rows_to_keep) rows from db
                while (sqlite3_step(stmt) == SQLITE_ROW) {
                //code
                }
      }
```
### error: Database is locked
 
### solution 
```

sqlite3_finalize(select_stmt); 
to be added after perform the first select statment
 
```
### resource 
```
https://www.arysontechnologies.com/blog/fix-sqlite-error-database-locked/#:~:text=for%20its%20solution.-,Reasons%20Responsible%20for%20Error%20Database%20is%20Locked,on%20the%20same%20database%20connection.

```
