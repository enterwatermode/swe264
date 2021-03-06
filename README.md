# swe264
project structure doc: https://docs.google.com/document/d/1MZTuVvD48gLe7zcLu6xJlhGP-1sOibOEJy7Pt6lDZqU/edit

# Apis
1. ### http://54.241.136.35:8080/data/content
   (Get) get all books  
   (Post) post a book

2. ### http://54.241.136.35:8080/data/content/{name}
   (Get) get a book by its name  
   Example: Get http://54.241.136.35:8080/data/content/Anthem

3. ### http://54.241.136.35:8080/data/content/get/{id}
   (Get) get a book by its id  
   http://54.241.136.35:8080/data/content/get/12

4. ### http://54.241.136.35:8080/data/names
   (Get) get all books' names
   
5. ### http://54.241.136.35:8080/data/namesId
   (Get) get all books' names and their ids

6. ### http://54.241.136.35:8080/data/content/{id}
   (Delete) delete a book by its id

7. ### http://54.241.136.35:8080/time/{time}
   (Post) post time information  
   Example: Post http://54.241.136.35:8080/time/13  
   Note: time is a string that has no format
   
8. ### http://54.241.136.35:8080/time/find/all
   (Get) get all the time information
