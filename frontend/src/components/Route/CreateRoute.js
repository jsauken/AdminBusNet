import React, { Component } from 'react';
import PropTypes from "prop-types";

class CreateRoute extends Component {
    constructor(props) {
        super(props);
        this.state = {
            origin: '',
            destination: '',
            distance: '',
            status: ''
        };
        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    }

    onChange(e) {
        this.setState({ [e.target.name]: e.target.value });
    }

    onSubmit(e) {
        e.preventDefault();
        const newRoute = this.state;
        this.props.addRoute(newRoute);
        this.setState({
            origin: '',
            destination: '',
            distance: '',
            status: ''
        });
    }

    render() {
        return (
            <form onSubmit={this.onSubmit}>
                <div>
                    <input
                        type="text"
                        name="origin"
                        placeholder="Origin"
                        value={this.state.origin}
                        onChange={this.onChange}
                    />
                </div>
                <div>
                    <input
                        type="text"
                        name="destination"
                        placeholder="Destination"
                        value={this.state.destination}
                        onChange={this.onChange}
                    />
                </div>
                <div>
                    <input
                        type="text"
                        name="distance"
                        placeholder="Distance"
                        value={this.state.distance}
                        onChange={this.onChange}
                    />
                </div>
                <div>
                    <input
                        type="text"
                        name="status"
                        placeholder="Status"
                        value={this.state.status}
                        onChange={this.onChange}
                    />
                </div>
                <div>
                    <input type="submit" value="Submit" />
                </div>
            </form>
        );
    }
}

CreateRoute.propTypes = {
    addRoute: PropTypes.func.isRequired,
};

export default CreateRoute;
