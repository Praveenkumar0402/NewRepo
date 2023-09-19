use pubs
select * from publishers

select pubid,count(*) as [files] from titles group by pubid
    select au_id,COUNT(*) as [no_of titles] from titleauthor group by au_id

select type,count(*) as count from titles where price < 10  group by type

select title_id,count(*)as [no_of authors] from titleauthor where title_id in (select title_id from titles where royalty>20) group by title_id

select * from titles
select * from publishers
select * from authors
select * from titleauthor


select pub_name,count(title_id)as [no_of titles] from publishers p join titles t on t.pubid = p.pub_id GROUP by pub_name

select a.au_lname,t.price,title from authors a join titleauthor ta on a.au_id=ta.au_id join titles t on ta.title_id=t.title_id

select t.type,count(t.title) as [no_of books] from titles t where price<10 group by type

select p.city,count(t.title) as [no_of books] from publishers p join titles t on p.pub_id=t.pubid GROUP by city

select p.pub_name, count(t.title) as [no_of books] from publishers p join titles t on p.pub_id=t.pubid 
where p.pub_id not in (select p.pub_id from publishers) group by pub_name


select au_fname,au_lname from authors where au_id in(select au_id from titles t join titleauthor ta on ta.title_id=t.title_id 
group by au_id having count(ta.title_id)>1)

select au_fname,au_lname from authors where au_id not in(select au_id from titles t join titleauthor ta on ta.title_id=t.title_id 
group by au_id)

select * FROM titles WHERE price > 10


select * from titles where title like '%Silicon%'

select ta.title_id,ta.au_id,t.title from titleauthor ta join titles t on t.title_id=ta.title_id

