import React, {Component} from 'react';
import RouteInfo from "./RouteInfo";
import PropTypes from "prop-types";

class Routes extends Component{

    render() {
        return this.props.routes.map((route) =>(
            <RouteInfo route={route} key={route.id} removeRoute={this.props.removeRoute}/>
        ));
    }
}

//PropTypes
Routes.propTypes = {
    routes: PropTypes.array.isRequired
}

export default Routes;
