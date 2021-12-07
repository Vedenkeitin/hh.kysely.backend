# hh.kysely.backend
backend from springboot

SQL LAUSE 
			@Query("SELECT " + " new hh.kyselybackend.domain.AnswerStatistics(a.content, COUNT(a)) "
					+ " FROM Answer a" + " WHERE QUESTION = {id}" + " GROUP BY a.content")
          

H2 CONSOLE
      SELECT CONTENT, COUNT(CONTENT)
      FROM ANSWER
      WHERE QUESTION = 7
      GROUP BY CONTENT

      SELECT *
      FROM ANSWER
      WHERE QUESTION = 7
