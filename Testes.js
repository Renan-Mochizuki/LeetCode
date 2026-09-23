const freq = new Array(26).fill(0);

const s = 'opaaaaa'

console.log(freq)
for (const char of s) {
    const index = char.charCodeAt(0) - 97;
    freq[index]++;
}

console.log(freq)