Fixed Size Sliding window

```
int i=0, j=0, sum=0, max = Integer.MIN_VALUE;

while(j < arr.length) {

  sum = sum + arr[j];

  if(j-i+1 < k) {
    j++;
  } else {
    //perform operation on the window
    max = Math.max(max, sum);

    //maintain sliding window
    i++;
    j++
  }
}


```
