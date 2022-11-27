#include <iostream>
#include <fstream> 
#include <algorithm>

using namespace std; 

int main() {
    ifstream fin ("lazy.in");
    ofstream fout ("lazy.out"); 

    int n; 
    int k; 

    fin >> n; 
    fin >> k; 

    int prefix[401][401]; 
    for(int i = 1; i<=n; i++) {
        for(int j = 1; j<=n; j++) {
            int x;
            fin >> x;  
            prefix[i][j] = prefix[i][j-1] + x; 
        }
    }
    int max = 0; 

    for(int i = 1; i<=n; i++) {
        for(int j = 1; j<=n; j++) {
            int a = std::max(1,j-k); 
            int A = std::min(n, j+k);  
            int sum = prefix[i][A]-prefix[i][a-1];  // origin row
            for(int l = 1; l<=k; l++) {  //rows above and below origin row
                int b = std::max(1,i-l); 
                int B = std::min(n, i+l); 
                sum += prefix[b][A-l] - prefix[b][a-1+l]; 
                sum += prefix[B][A-l] - prefix[B][a-1+l]; 
            }
            if(sum>max) {
                max = sum; 
            }
        }
    }

    fout << max << "\n";
    cout << max;

    return 0; 
}

