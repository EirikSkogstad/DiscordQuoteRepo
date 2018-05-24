import React, { Component } from "react";
import "./App.css";
import QuoteCard from "./components/QuoteCard";

class App extends Component {
  constructor() {
    super();
    this.state = {
      quotes: [
        {
          text:
            "Hello world, this is Jeff speaking. " +
            "Hello world, this is Jeff speaking. " +
            "Hello world, this is Jeff speaking. " +
            "Hello world, this is Jeff speaking." +
            "Hello world, this is Jeff speaking." +
            "Hello world, this is Jeff speaking." +
            "Hello world, this is Jeff speaking." +
            "Hello world, this is Jeff speaking." +
            "Hello world, this is Jeff speaking." +
            "Hello world, this is Jeff speaking.",
          author: "Totally not Jeff"
        }
      ]
    };
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <h1 className="App-title">Welcome to React</h1>
        </header>

        <div className="quotecard-container">
          {[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12].map(e => {
            return <QuoteCard key={e} quote={this.state.quotes[0]} />;
          })}
        </div>
      </div>
    );
  }
}

export default App;
