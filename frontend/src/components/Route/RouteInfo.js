import React, {Component} from 'react';
import PropTypes from "prop-types";
import LocationOnIcon from '@material-ui/icons/LocationOn';
import DeleteIcon from '@material-ui/icons/Delete';
import IconButton from '@material-ui/core/IconButton';

class RouteInfo extends Component{

    // Dynamic Styling
    infoStyle = () =>{
        return {
            backgroundColor: (this.props.route.id % 2) === 0 ? '#c8d4f7cc' : '',
            padding:'10px',
            borderBottom: '1px #ccc dotted',
            display:'flex',
            alignItems:'center',
            justifyContent:'space-between',
            justifyItems: 'flex-start',
        }
    }

    render() {

        const {id} = this.props.route;
        return(
            <div style={this.infoStyle()}>
                <div style={iconLocation}>
                    <LocationOnIcon style={{color:"#138a04", margin:"0px 10px 0px 0px"}}/>
                    <p>{this.props.route.origin }</p>
                </div>

                <p>{this.props.route.destination }</p>
                <p>{this.props.route.distance}</p>
                <div style={buttons}>
                    <IconButton color="secondary" onClick={this.props.removeRoute.bind(this, id)}>
                        <DeleteIcon />
                    </IconButton>
                </div>

            </div>
        );
    }
}

const iconLocation = {
    display: 'flex',
    justifyContent:'space-between',
}

const buttons = {
    display: 'flex'
}

// PropTypes
RouteInfo.propTypes = {
    route: PropTypes.object.isRequired
}

export default RouteInfo;