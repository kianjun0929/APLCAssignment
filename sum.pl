addup([],0).
addup([FirstNumber | RestOfList], Total) :-
    addup(RestOfList, TotalOfRest),
    Total is FirstNumber + TotalOfRest.