#include <iostream>
#include <cmath>
#include <unistd.h>

using namespace std;

int main(int argc, const char * argv[]) {
    const int easy = 10, medium = 100, hard = 1000;
    bool wantsToQuit = false;
    
    cout << "Welcome to Guess the Number C++ Edition!\r\nMade by Evan Crabtree\r\n2019 v1.1\r\n\r\n";
    
    while (!wantsToQuit) {
        int diff, difficulty;
        cout << "(1) Easy\r\n(2) Medium\r\n(3) Hard\r\n(0) Custom\r\n\t\tChoose a difficulty: ";
        cin >> diff;
        
        switch (diff) {
            case 1:
                difficulty = easy;
                break;
            case 2:
                difficulty = medium;
                break;
            case 3:
                difficulty = hard;
                break;
            case 0:
                cout << "\t\tEnter a maximum number: ";
                cin >> difficulty;
                while (difficulty < 5) {
                    cout << "\t\tSorry, the number must be 5 or greater: ";
                    cin >> difficulty;
                }
                cout << endl;
                break;
            default:
                difficulty = medium;
                break;
        }
        
        int x = (int)(random() % difficulty);
        int n, guesses = ((int)sqrt(difficulty/8))+2;
        bool won = false;
        string input;
        
        cout << "Number is between 0 and " << difficulty << "\r\n\r\n";
        
        while (guesses > 0 && !won) {
            cout << "Guesses: " << guesses << "\tGuess the number: ";
            
            cin >> n;
            guesses--;
            cout << endl;
            
            if (n == x) {
                won = true;
            } else if (n > x) {
                cout << "\t\tYour guess is too high\r\n\r\n";
            } else if (n < x) {
                cout << "\t\tYour guess is too low\r\n\r\n";
            }
        }
        
        cout << "The number: " << x;
        
        if (won) {
            cout << "\t\tYou win!\r\n";
        } else {
            cout << "\t\tYou lose!\r\n";
        }
        
        cout << "\t\tWould you like to play again? Y/N: ";
        cin >> input;
        
        if (input != "Y" && input != "y") {
            wantsToQuit = true;
            cout << endl;
        }
    }
    
    cout << "\t\tThanks for playing!\r\n";
    try {
        sleep(5/2);
    } catch (exception e) {
        
    }
    
    return 0;
}
