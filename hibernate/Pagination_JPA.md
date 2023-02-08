## Why to use it?
to limit the results. we sometime don't want to retrieve all the records with only one call.

## In JPA:
we compose Pageable like this:
```
OffsetBasedPageRequest pageable = new OffsetBasedPageRequest(limit, offset);
```
then we call
```
service.getEEntity(pageable);
```
then we construct the native query in the repo, and include the **countQuery** to select the no of records to be retrieved based on the query in the countQuery
```
/*
Native query
*/
,countQuery = "select count (*) from table_name"
            ,nativeQuery = true)
Page<Entity> getEntity(OffsetBasedPageRequest pageable);
```
