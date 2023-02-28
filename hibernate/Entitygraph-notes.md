1-join fetch useful in scenarios invloving lazy associations that should be fetched eagerly to avoid loading exeptions and n+1 inssues.

2-While (LEFT) JOIN FETCH lives
inside the query, entity graphs are independent of the query. Therefore, the query
and entity graphs can be reused (e.g., a query can be used with or without an
entity graph, while an entity graph can be used with different queries)

3-entity graphs  => fetch plans

4-entity graphs supprted from 2.1 jpa

5-we specifies the entity’s related associations and basic fields
that should be loaded in a single SELECT statement

6-same entity can have multiple fetch plans(entity graphs)

7-for complex fetch plans we cas use sub-graphs

8-what is in attributeNode is fetch eager and override anything, what not in attribute node is lazy and overrides everything

9- what is in load graph is fetch eager and override anything, what not in attribute node is defaulted/what specified

