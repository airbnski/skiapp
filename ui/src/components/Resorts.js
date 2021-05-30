import axios from "axios";

import InteractiveMap from "./InteractiveMap";
import ResortList from "./ResortList";
import Filters from "./Filters";
import {Grid, InputAdornment, Snackbar, TextField} from "@material-ui/core";
import {Component, useEffect, useState} from "react";
import LocationOnOutlinedIcon from "@material-ui/icons/LocationOnOutlined";
import FilterListIcon from "@material-ui/icons/FilterList";
import {
    positionStackAPIKey,
    positionStackUrl,
    resortServiceUrl,
} from "../config";
import * as PropTypes from "prop-types";

class Alert extends Component {
    render() {
        return null;
    }
}

Alert.propTypes = {
    severity: PropTypes.string,
    onClose: PropTypes.any,
    children: PropTypes.node,
};

function Resorts(props) {
    const [searchLocation, setSearchLocation] = useState("Zurich");
    const [searchLatitude, setSearchLatitude] = useState(0);
    const [searchLongitude, setSearchLongitude] = useState(0);
    const [searchDistance, setSearchDistance] = useState(1000);
    const [showFilters, setShowFilters] = useState(false);
    const [snackbarOpen, setSnackbarOpen] = useState(false);
    const [snackbarMessage, setSnackbarMessage] = useState("");
    const [currentWeather, setCurrentWeather] = useState("All");
    const [currentTemperature, setCurrentTemperature] = useState([-5, 25]);

    useEffect(() => {
        searchForResorts();
    }, []);

    const searchForResorts = (loc = searchLocation, dist = searchDistance) => {
        props.clearResorts();
        if (dist !== searchDistance) {
            setSearchDistance(dist);
        }
        return getSearchCoordinates(loc).then((potentialLocation) => {
            console.log("potentialLocation: ", potentialLocation);
            if (potentialLocation) {
                setSearchLatitude(potentialLocation.latitude);
                setSearchLongitude(potentialLocation.longitude);
                return getResortsByLocation(
                    potentialLocation.longitude,
                    potentialLocation.latitude,
                    dist
                );
            }
        });
    };

    const getResortsByLocation = (longitude, latitude, radius) => {
        return axios
            .get(
                resortServiceUrl +
                "/resort/" +
                longitude +
                "/" +
                latitude +
                "/" +
                radius
            )
            .then((res) => {
                console.log("GET RESORTS BY LOCATION: ", res.data);
                props.updateResortList(res.data, ["normal", "filtered"]);
                return res.data;

            });
    };


    const getSearchCoordinates = (loc = searchLocation) => {
        console.log("GET SEARCH COORDINATES FOR ", loc);
        return axios
            .get(
                positionStackUrl +
                "/forward" +
                "?access_key=" +
                positionStackAPIKey +
                "&query=" +
                loc
            )
            .then((res) => {
                return res.data.data[0];
            });
    };

    const handleKeyPress = (e) => {
        if (e.keyCode === 13) {
            console.log("value", e.target.value);
            searchForResorts(e.target.value);
        }
    };

    const filterResorts = (distance, weather, minTemp, maxTemp) => {
        console.log(
            "FILTER RESULTS ON: ",
            distance,
            ", ",
            weather,
            ", ",
            minTemp,
            " - ",
            maxTemp
        );
        let newList = props.resortList;
        // Filter by distance
        newList = newList.filter((r) => r.distance <= distance);
        setSearchDistance(distance);
        console.log("New distance", newList);
        // Filter by weather
        setCurrentWeather(weather);
        if (weather !== "All") {
            newList = newList.filter((r) => r.weather.outlook === weather);
            console.log("New weather", newList);
        }
        // Filter by temperature
        newList = newList.filter(
            (r) =>
                r.weather.temperature >= minTemp && r.weather.temperature <= maxTemp
        );
        setCurrentTemperature([minTemp, maxTemp]);
        console.log("New temp", newList);

        props.updateResortList(newList, ["filtered"]);
    };

    return (
        <Grid container spacing={2} style={{margin: 0, overflowX: "auto"}}>
            <Grid item xs={3} style={{height: 'calc(100vh - 70px)', overflowY: 'auto',}}>
                <div style={{display: 'flex', flexDirection: 'row', alignItems: 'center'}}>
                    <TextField id="location" type="text" label="Location" variant="outlined"
                               InputProps={{
                                   startAdornment: (
                                       <InputAdornment position="start">
                                           <LocationOnOutlinedIcon/>
                                       </InputAdornment>
                                   ),
                               }}
                               style={{width: '90%', margin: 10}}
                               value={searchLocation}
                               onChange={(e, s) => setSearchLocation(s)}
                               onKeyDown={handleKeyPress}
                    />
                    <FilterListIcon style={{fontSize: 40}} onClick={() => setShowFilters(!showFilters)}/>
                </div>
                <ResortList resorts={props.filteredResortList} loading={props.loading}/>
            </Grid>
            <Grid item xs={9} style={{height: 'calc(100vh - 70px)'}}>
                <InteractiveMap resorts={props.filteredResortList} lat={searchLatitude} long={searchLongitude}/>
            </Grid>


            {showFilters ?
                <Filters open={showFilters} handleClose={() => setShowFilters(!showFilters)} search={filterResorts}
                         updateDistance={searchForResorts}
                         loc={searchLocation} currentDistance={searchDistance}
                         currentWeather={currentWeather} currentTemperature={currentTemperature}/> : null}
            <Snackbar open={snackbarOpen} autoHideDuration={6000} onClose={() => setSnackbarOpen(false)}>
                <Alert onClose={() => setSnackbarOpen(false)} severity="info">
                    {snackbarMessage}
                </Alert>
            </Snackbar>
        </Grid>
    );
}

export default Resorts;
