quickSort([], []).
quickSort([Head|Tail], SortedList) :-
    partition(Head, Tail, LargerValue, SmallerValue),
    quickSort(LargerValue, SortedLargerSubList),
    quickSort(SmallerValue, SortedSamllerSubList),
    append(SortedLargerSubList, [Head|SortedSamllerSubList], SortedList).

partition(_, [], [], []).
partition((PivotKey, PivotValue), [(ComparedKey, ComparedValue)|Tail], 
	[(ComparedKey, ComparedValue)|LargerValue], SmallerValue) :-
    ComparedValue > PivotValue,
    partition((PivotKey, PivotValue), Tail, LargerValue, SmallerValue).
partition((PivotKey, PivotValue), [(ComparedKey, ComparedValue)|Tail], 
	LargerValue, [(ComparedKey, ComparedValue)|SmallerValue]) :-
    ComparedValue =< PivotValue,
    partition((PivotKey, PivotValue), Tail, LargerValue, SmallerValue).