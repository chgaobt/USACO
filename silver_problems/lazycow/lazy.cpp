#include <iostream>
#include <fstream> 

using namespace std; 

int main() {
    ifstream fin ("lazy.in");
    ofstream fout ("lazy.out"); 

    int n; 
    int k; 

    fin >> n; 
    fin >> k; 

    cout << n;
    cout <<k;
    
    return 0; 
}

