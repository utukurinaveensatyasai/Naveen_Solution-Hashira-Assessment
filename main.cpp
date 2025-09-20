#include <bits/stdc++.h>
#include <boost/multiprecision/cpp_int.hpp> 
#include "json.hpp"

using namespace std;
using json = nlohmann::json;
using namespace boost::multiprecision;
using bigint = cpp_int;

bigint baseToDecimal(const string &value, int base) {
    bigint result = 0;
    for (char c : value) {
        int digit = (isdigit(c) ? c - '0' : c - 'a' + 10);
        result = result * base + digit;
    }
    return result;
}

vector<bigint> multiplyPoly(const vector<bigint> &poly, const bigint &root) {
    vector<bigint> res(poly.size() + 1, 0);
    for (size_t i = 0; i < poly.size(); i++) {
        res[i] += poly[i];
        res[i + 1] -= root * poly[i];
    }
    return res;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

  
    string input, line;
    while (getline(cin, line)) input += line;

    json j;
    try {
        j = json::parse(input);
    } catch (json::parse_error &e) {
        cerr << "Invalid JSON input: " << e.what() << endl;
        return 1;
    }

    int n = j["keys"]["n"];
    int k = j["keys"]["k"];

    vector<bigint> roots;
    for (int i = 1; i <= n && roots.size() < (size_t)k; i++) {
        string key = to_string(i);
        if (!j.contains(key)) continue;
        int base = stoi((string)j[key]["base"]);
        string value = j[key]["value"];
        roots.push_back(baseToDecimal(value, base));
    }

    vector<bigint> coeff = {1};
    for (const auto &r : roots) {
        coeff = multiplyPoly(coeff, r);
    }

    for (const auto &c : coeff) cout << c << " ";
    cout << endl;

    return 0;
}
