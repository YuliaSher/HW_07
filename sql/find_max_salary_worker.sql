SELECT name, salary
from worker
WHERE salary >= All (SELECT salary FROM worker)
ORDER BY salary DESC;