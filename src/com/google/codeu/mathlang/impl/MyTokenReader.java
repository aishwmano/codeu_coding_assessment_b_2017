// Copyright 2017 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.codeu.mathlang.impl;

import java.io.IOException;

import com.google.codeu.mathlang.core.tokens.Token;
import com.google.codeu.mathlang.parsing.TokenReader;

// MY TOKEN READER
//
// This class parses text input and converts it to a stream of tokens
public final class MyTokenReader implements TokenReader {
  private String source;
  private int index;

  public MyTokenReader(String source) {
    this.source = source;
    index = 0;
  }

  // returns a token object based on what type of token is next in
  // the sequence of the input string
  // if invalid input is given, returns null
  @Override
  public Token next() throws IOException {
    String[] tokens = source.split("\\s+");
    if (index < tokens.length) {
      String nextWord = tokens[index].toLowerCase();
      index++;
      // if next word is a symbol token
      if (nextWord.length() == 1) {
        getSymbolTokenObject(nextWord);
      // checks if the next word is a name token or string token
      // and returns a new token object accordingly
      } else if (nextWord.charAt[0] >= 97 && nextWord.charAt[0] <= 122) {
        if (isName(nextWord)) {
          return getNameTokenObject(nextWord);
        } else {
          return getStringTokenObject(nextWord);
        }
      // checks if the next token is number or string token
      // and returns a new token object accordingly
      } else if (nextWord.charAt[]) {
        if (isNumberToken(nextWord)) {
          return getNumberTokenObject(nextWord);
        } else {
          return getStringTokenObject(nextWord);
        }
      } else {
        return null;
      }
  }

  // returns if given string is a name token
  private boolean isNameToken(String word) {
    for (int i = 0; i < word.length(); i++) {
      if (!(word.charAt(i) >= 'a' && word.charAt(i) <= 'z')){
        return false;
      }
    }
    return true;
  }

  // returns whether given string is a number token
  private boolean isNumberToken(String word) {
    for (int i = 0; i < word.length(); i++)) {
      if (!(word.charAt(i) >= '0' && word.charAt(i)<= '9') || word.charAt(i) == '.') {
        return false;
      }
    }
    return true;
  }

  // returns a symbol token object with given string
  private SymbolToken getSymbolTokenObject(String sym) {
    char symbol = sym.charAt(0);
    return new SymbolToken(symbol);
  }

  // returns a name token object with given string
  private NameToken getNameTokenObject(String sym) {
    return new NameToken(sym);
  }

  // returns a number token object with given string
  private SymbolToken getNumberTokenObject(String sym) {
    return new NumberToken(sym);
  }

  // returns a string token object with given string
  private SymbolToken getStringTokenObject(String sym) {
    return new StringToken(sym);
  }
}
