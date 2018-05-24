import React, { Component } from "react";
import "./QuoteCard.css";

class QuoteCard extends Component {
  render() {
    const quote = this.props.quote;
    if (quote) {
      return (
        <div className="quotecard-wrapper">
          <p className="quotecard-text">{quote.text}</p>
          <p className="quotecard-author">- {quote.author}</p>
          <div className="quotecard-votebutton-container">
            <a className="quotecard-votebutton">+1</a>
            <a className="quotecard-votebutton">-1</a>
          </div>
        </div>
      );
    }

    console.error("QuoteCard: No quote supplied in props!", quote);
    return (
      <div className="quotecard-wrapper">
        <p>Error:No quote supplied to this Card!</p>
      </div>
    );
  }
}

export default QuoteCard;
