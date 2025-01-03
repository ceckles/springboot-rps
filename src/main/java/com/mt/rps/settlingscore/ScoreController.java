package com.mt.rps.settlingscore;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class ScoreController {
    static Score score = new Score(30, 20, 10);

    @GetMapping("/health-check")
    public String getHealthCheck() {
        return "Situation Normal All Fired Up";
    }

    @GetMapping("/score")
    public Score getScore() {
        return score;
    }

    // Basic way create each endpoint
    //    @GetMapping("/score/wins")
    //    public int getWins() {
    //        return score.getWins();
    //    }
    //
    //    @GetMapping("/score/ties")
    //    public int getTies() {
    //        return score.getTies();
    //    }
    //
    //    @GetMapping("/score/losses")
    //    public int getLosses() {
    //        return score.getLosses();
    //    }

    //Better way use path variable.
    @GetMapping("/score/{winlossesties}")
    public int getWinLossesOrTies(@PathVariable String winlossesties) {
        if (winlossesties.equalsIgnoreCase("wins")) {
            return score.getWins();
        } else if (winlossesties.equalsIgnoreCase("losses")) {
            return score.getLosses();
        } else {
            return score.getTies();
        }
    }

    //Increase Wins
    //Individual route
//    @PostMapping("/score/wins")
//    public Score increaseWins(){
//        score.setWins(score.getWins() + 1);
//        return score;
//    }
//    @PostMapping("/score/losses")
//    public Score increaseLosses(){
//        score.setLosses(score.getLosses() + 1);
//        return score;
//    }
//    @PostMapping("/score/ties")
//    public Score increaseTies(){
//        score.setTies(score.getTies() + 1);
//        return score;
//    }

    //Increase the socre values
    //Streamline route
    @PostMapping("/score/{winslossesties}")
    public Score setWinLossesOrTies(@PathVariable String winslossesties) {
        if (winslossesties.equalsIgnoreCase("wins")) {
            score.setWins(score.getWins() + 1);
            return score;
        } else if (winslossesties.equalsIgnoreCase("losses")) {
            score.setLosses(score.getLosses() + 1);
            return score;
        } else {
            score.setTies(score.getTies() + 1);
            return score;
        }
    }
// Individual routes
//    @PatchMapping("/score/wins")
//    public Score updateWins(@RequestParam(name="new-value")int newValue){
//        score.setWins(newValue);
//        return score;
//    }
//    @PatchMapping("/score/losses")
//    public Score updateLosses(@RequestParam(name="new-value")int newValue){
//        score.setLosses(newValue);
//        return score;
//    }
//    @PatchMapping("/score/ties")
//    public Score updateTies(@RequestParam(name="new-value")int newValue){
//        score.setTies(newValue);
//        return score;
//    }

    //Group Routes
    //Patch Route for score to patch a score
    @PatchMapping("/score/{winslossesties}")
    public Score patchWinLossesOrTies(@PathVariable String winslossesties, @RequestParam(name = "new-value") int newValue) {
        if (winslossesties.equalsIgnoreCase("wins")) {
            score.setWins(newValue);
            return score;
        } else if (winslossesties.equalsIgnoreCase("losses")) {
            score.setLosses(newValue);
            return score;
        } else {
            score.setTies(newValue);
            return score;
        }
    }


    //Put Route for score to replace score
    @PutMapping("/score")
    public Score replaceScore( @RequestBody Score newScore) {
        score = newScore;
        return score;
    }

    //Delete Route for Score
    @DeleteMapping("/score")
    public void deleteScore(){
        //don't know why you would do this but giving the option, would need to put score inorder to continue.
        score = null;
    }
}
