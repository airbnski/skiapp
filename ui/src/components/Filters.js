import {
    Button,
    Dialog,
    DialogActions,
    DialogContent,
    DialogTitle, FormControl, makeStyles, MenuItem, Select, Slider,
} from "@material-ui/core";
import {useState} from "react";

const useStyles = makeStyles({
    formControl: {
        width: '90%',
        margin: '5px 5px'
    },
});

function Filters(props) {
    const classes = useStyles();

    const [searchDistance, setSearchDistance] = useState(props.currentDistance)
    const [weather, setWeather] = useState(props.currentWeather)
    const offset = -15
    const stepSize = 10
    const magnifier = 2
    const [temperature, setTemperature] = useState([(props.currentTemperature[0] - offset) * magnifier, (props.currentTemperature[1] - offset) * magnifier])


    const handleDistanceChange = (e, dist) => {
        setSearchDistance(dist)
    }

    const handleTemperatureChange = (e, temp) => {
        setTemperature(temp)
    }

    const temperatureMarks = [
        {
            value: 0,
            label: offset + '°C',
        },
        {
            value: stepSize * magnifier,
            label: offset + stepSize + '°C',
        },
        {
            value: 2 * stepSize * magnifier,
            label: offset + 2 * stepSize + '°C',
        },
        {
            value: 3 * stepSize * magnifier,
            label: offset + 3 * stepSize + '°C',
        },
        {
            value: 4 * stepSize * magnifier,
            label: offset + 4 * stepSize + '°C',
        },
        {
            value: 5 * stepSize * magnifier,
            label: offset + 5 * stepSize + '°C',
        },
    ];

    const calculateTemp = (temp) => {
        return temp / magnifier + offset
    }

    const submit = () => {
        props.search(searchDistance, weather, calculateTemp(temperature[0]), calculateTemp(temperature[1]))
        props.handleClose()
    }

    return (
        <div>
            <Dialog
                open={props.open}
                onClose={props.handleClose}
            >
                <DialogTitle>{"Filter your results"}</DialogTitle>
                <DialogContent style={{marginBottom: 20, overflowY: 'hidden'}}  >
                    <FormControl className={classes.formControl}>
                        <h3>Distance</h3>
                        <Slider
                            value={searchDistance}
                            onChange={handleDistanceChange}
                            valueLabelDisplay="on"
                            style={{marginTop: 15}}
                        />
                    </FormControl>
                    <FormControl className={classes.formControl}>
                        <h3 >Weather</h3>
                        <Select
                            labelId="search-weather"
                            value={weather}
                            onChange={(e) => setWeather(e.target.value)}
                            variant="outlined"
                        >
                            <MenuItem value={'All'}>All</MenuItem>
                            <MenuItem value={'Clear'}>Sunny</MenuItem>
                            <MenuItem value={'Clouds'}>Cloudy</MenuItem>
                            <MenuItem value={'Rain'}>Rain</MenuItem>
                            <MenuItem value={'Atmosphere'}>Partly Cloudy</MenuItem>
                            <MenuItem value={'Snow'}>Snow</MenuItem>
                        </Select>
                    </FormControl>
                    <FormControl className={classes.formControl}>
                        <h3 >Temperature</h3>
                        <Slider
                            value={temperature}
                            onChange={handleTemperatureChange}
                            marks={temperatureMarks}
                            style={{margin: '0px 15px'}}
                        />
                    </FormControl>
                </DialogContent>
                <DialogActions>
                    <Button onClick={submit} color="primary">
                        Search
                    </Button>
                </DialogActions>
            </Dialog>
        </div>
    )
}

export default Filters;