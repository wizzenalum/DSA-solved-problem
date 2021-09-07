// manachars method to find the longest palindrome
function manacher(stringy){
    const len = stringy.length*2+1
    let lps = new Array(len).fill(0)
    lps[1] = 1;
    let center = 1, right =2,maxIndex = 1;
    for (let index = 2; index < lps.length; index++) {
        const indexMirror = 2*center-index, diff = right-index;

        if(diff>0) lps[index] = Math.min(diff,lps[indexMirror]);
        try {
            while((index+lps[index]<len && index-lps[index]>0) && (((index+lps[index]+1)%2==0)||
                 (stringy.charAt(parseInt((index+lps[index]+1)/2))===stringy.charAt(parseInt((index-lps[index]-1)/2))))){
                    // console.log(lps[index],index) 
                    lps[index]++;
                 }
        } catch (error) {
        }
        if(index+lps[index]>right){
            right = index+lps[index]
            center = index
        }
        if(lps[maxIndex]<lps[index]){
            maxIndex = index
        }
    }
    const start = parseInt((maxIndex-lps[maxIndex])/2);
    const end = parseInt((maxIndex+lps[maxIndex]-1)/2);
    console.log(stringy.substring(start,end+1));
    
    console.log("this is lps",lps,maxIndex)

}
// manacher("babcbabcbaccba")
manacher("abacdfgdcaba")
// manacher("forgeeksskeegfor")