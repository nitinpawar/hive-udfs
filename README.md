hive-udfs
=========

A directory of hive udf functions created for use cases. 

First function tried is FromUnixtimeWithTZ

FromUnixtimeWithTZ takes epoch time in mili seconds as input along with timezone(list can be found at http://tutorials.jenkov.com/java-date-time/java-util-timezone.html)
and returns the time in that timezone for epoch time. If no timezone is provided then it returns for UTC. 
sample output:
            System.out.println(gdm.evaluate(1415232000000L, "UTC"));
	          System.out.println(gdm.evaluate(1415232000000L, "Asia/Calcutta"));
	          System.out.println(gdm.evaluate(1415232000000L, "US/Pacific"));
            System.out.println(gdm.evaluate(1415232000000L, ""));
            System.out.println(gdm.evaluate(0L, "UTC"));
            System.out.println(gdm.evaluate(0L, "Asia/Calcutta"));
            System.out.println(gdm.evaluate(0L, "US/Pacific"));
            System.out.println(gdm.evaluate(0L, ""));
            
            06/11/2014 00:00:00
            06/11/2014 05:30:00
            05/11/2014 16:00:00
            06/11/2014 00:00:00
            01/01/1970 00:00:00
            01/01/1970 05:30:00
            31/12/1969 16:00:00
            01/01/1970 00:00:00
