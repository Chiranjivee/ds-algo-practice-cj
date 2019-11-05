# Write your MySQL query statement below
select FirstName, LastName, City, State from Person LEFT JOIN Address ON Person.PersonId = Address.PersonId;