package com.essaisprint.firstspring.controllers;

import java.util.List;

import com.essaisprint.firstspring.daos.ElectionDao;
import com.essaisprint.firstspring.daos.VoteDao;
import com.essaisprint.firstspring.exceptions.AucunVoteException;
import com.essaisprint.firstspring.exceptions.VoteException;
import com.essaisprint.firstspring.models.Vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * VoteController
 */
@RestController
public class VoteController {
    @Autowired
    private VoteDao voteDao;
    // @Autowired
    // private ElectionDao electionDao;

    @PostMapping(value = "/votes")
    public ResponseEntity<Vote> ajouter(@RequestBody Vote vote) {
        try {
            // Vote vote_trouve = vote Dao.fin
            Vote voteAdded = voteDao.save(vote);

            if (voteAdded == null)
                return ResponseEntity.noContent().build();

            // URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            // .buildAndExpand(electionAdded.getId()).toUri();
            return new ResponseEntity<Vote>(voteAdded, HttpStatus.CREATED);

        } catch (Exception e) {
            throw e;
        }

    }

    @GetMapping(value = "/votes/{idElecteur}/{idElection}")
    public ResponseEntity<Vote> veifierDejaVote(@PathVariable String idElecteur, @PathVariable String idElection)
            throws VoteException {
        Vote vote = voteDao.findByIdElecteurAndIdElection(Long.parseLong(idElecteur), Long.parseLong(idElection));
        if (vote == null)
            throw new VoteException("Electeur n'a pas encore voté");

        return new ResponseEntity<Vote>(vote, HttpStatus.OK);
    }

    @GetMapping(value="/votes/resultat/{idCandidat}/{idElection}")
    public ResponseEntity< List<Vote>> resulatVote(@PathVariable String idCandidat, @PathVariable String  idElection) throws AucunVoteException {
        List<Vote> votes = voteDao.findByIdCandidatAndIdElection(Long.parseLong(idCandidat),Long.parseLong(idElection));
        if(votes == null)
            throw new VoteException("Acun vote enregistré pour ce candidat");
     
        return new ResponseEntity<List<Vote> >(votes, HttpStatus.OK);
    }
    @GetMapping(value="/votes/nbvote/election/{idElection}")
    public ResponseEntity< List<Vote>> nbVoteElection(@PathVariable String  idElection) throws AucunVoteException {
        List<Vote> votes = voteDao.findByIdElection(Long.parseLong(idElection));
        if(votes == null)
            throw new VoteException("Acun vote enregistré pour ce candidat");
     
        return new ResponseEntity<List<Vote> >(votes, HttpStatus.OK);
    }

}
