import React from "react";

import EmptyState from "./components/EmptyState";
import List from "./components/List";
import listMovies from "./movies.json";
import "./App.css";
import Toggle from 'react-toggle'

export default class App extends React.Component {
    state = {
        favItems: [],
        show: true
    };
    handleToggle = () => {
        const {show} = this.state;
        this.setState({show : !show});
    }

    handleItemClick = (item) => {
        const newItems = [ ... this.state.favItems];
        const newItem = { ... item };

        const targetInd = newItems.findIndex((it) => it.id === newItem.id);

        newItems.splice(targetInd, 1);

        this.setState({favItems: newItems});
    };
    handleItemClickRev1 = (item) => {
        const newItems = [ ... this.state.favItems];
        const newItem = { ... item };

        const targetInd = newItems.findIndex((it) => it.id === newItem.id);

        if(targetInd < 0) newItems.push(newItem);

        this.setState({favItems: newItems});
    };
    clearFavorite = () => {
        this.setState({favItems: []});
    };

    render() {
        const {favItems} = this.state;
        return(
            <div className="container-fluid">
                <h1 className="text-center mt-3 mb-0"> Favorites Movie App</h1>
                <p className="text-center text-secondary text-sm font-italic">
                    (This is a <strong>class-based</strong> application)
                </p>
                <div className="row justify-content-md-center">
                    <label>
                        <Toggle
                            defaultChecked={this.state.show}
                            icons={false}
                            onChange={this.handleToggle} />
                        <span>Show Favorites</span>
                    </label>
                </div>
                <div className="container pt-3">
                    <div className="row">
                        <div className="col-sm">
                            <List
                                title="List Movies"
                                items={listMovies}
                                onItemClick={this.handleItemClickRev1}
                            />
                        </div>
                        {this.state.show ?
                        <div className="col-sm">
                            {!this.state.favItems.length ? <EmptyState/> :
                                <div>
                                    <input
                                        className="float-right"
                                        type={this.state.favItems.length === 0 ? 'hidden':'button'}
                                        onClick={this.clearFavorite}
                                        value="Clear Favorite"
                                    />
                                    <List
                                        title = "My Favorite"
                                        items = {favItems}
                                        onItemClick = {this.handleItemClick}
                                    />
                                </div>}
                        </div>
                            : null}
                    </div>
                </div>
            </div>
        );
    }
}