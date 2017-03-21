var quickSort = function (arr,l,r) {
	if ( l < r) {
		debugger;
		var pivot = partition(arr,l,r);
		quickSort(arr,l,pivot - 1);
		quickSort(arr,pivot + 1,r);
	}
	console.log();
}
function partition(arr,l,r){
	var pivot = arr[r];
	for(var  i = l;i<r; i++){
		if(arr[i] < pivot){
			swap(arr,i,l);
			l++;
		}
	}
	swap(arr,l,r);
	return l;
}
function swap(arr,j,k){
	var tmp = arr[j];
	arr[j] = arr[k];
	arr[k] = tmp;
}
var s = [8, 1, 6, 7, 5];
quickSort(s,0,s.length-1)
console.log(s);
