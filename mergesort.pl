halve([], [], []).
halve([A], [A], []).
halve([A,B|Cs], [A|X], [B|Y]) :- halve(Cs, X, Y).

merge([], Ys, Ys).
merge(Xs, [], Xs).
merge([(X1,X2)|Xs], [(Y1,Y2)|Ys], M) :-
   (  
      X2 > Y2 -> M = [(X1,X2)|Ms], merge(Xs, [(Y1,Y2)|Ys], Ms); M = [(Y1,Y2)|Ms], merge([(X1,X2)|Xs], Ys, Ms) 
   ).

mergeSort([], []).
mergeSort([E], [E]).
mergeSort([E1,E2|Es], SL) :- 
     halve([E1,E2|Es], L1, L2),
     mergeSort(L1, SL1),
     mergeSort(L2, SL2),
     merge(SL1, SL2, SL). 