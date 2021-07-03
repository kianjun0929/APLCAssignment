quickSort([], []).
quickSort([Head|Tail], SortedList) :-
    partition(Head, Tail, LargerValue, SmallerValue),
    quickSort(LargerValue, SortedLargerSubList),
    quickSort(SmallerValue, SortedSamllerSubList),
    append(SortedLargerSubList, [Head|SortedSamllerSubList], SortedList).

partition(_, [], [], []).
partition((PivotKey, PivotValue), [(ComparedKey, ComparedValue)|Tail], 
	[(ComparedKey, ComparedValue)|LargerValue], SmallerValue) :-
    PivotValue > ComparedValue,
    partition((PivotKey, PivotValue), Tail, LargerValue, SmallerValue).
partition((PivotKey, PivotValue), [(ComparedKey, ComparedValue)|Tail], 
	LargerValue, [(ComparedKey, ComparedValue)|SmallerValue]) :-
    PivotValue =< ComparedValue,
    partition((PivotKey, PivotValue), Tail, LargerValue, SmallerValue).

addup([],0).
addup([FirstNumber | RestOfList], Total) :-
    addup(RestOfList, TotalOfRest),
    Total is FirstNumber + TotalOfRest.