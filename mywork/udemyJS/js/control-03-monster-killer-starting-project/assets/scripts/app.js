const ATTACK_VALUE = 10;
const STRONG_ATTACK_VALUE = 17;
const MONSTER_ATTACK_VALUE = 14;

let chosenMaxLife = 50;
let currentMonsterHealth = chosenMaxLife;
let currnetPlayerHealth = chosenMaxLife;

adjustHealthBars(chosenMaxLife);

function attackMonster(mode){
    let maxDamage;
   if (mode == 'ATTACK'){
       maxDamage = ATTACK_VALUE;
   } else if (mode == 'STRONG_ATTACK'){
       maxDamage = STRONG_ATTACK_VALUE;
   }

    const damege = dealMonsterDamage(maxDamage)
    currentMonsterHealth -= damege;
    const playerDamage = dealPlayerDamage(MONSTER_ATTACK_VALUE);
    currnetPlayerHealth -= playerDamage;
    if (currentMonsterHealth <= 0 && currnetPlayerHealth > 0) {
        alert("you Won!!");
    } else if (currnetPlayerHealth <= 0 && currentMonsterHealth > 0) {
        alert("you Lost!!");
    } else if (currentMonsterHealth <= 0 && currnetPlayerHealth <= 0) {
        alert("draw!")
    }

}

function attackHandler() {
attackMonster('ATTACK');
}

function strongAttackHandler(){
    attackMonster('STRONG_ATTACK');
}
attackBtn.addEventListener('click', attackHandler);
strongAttackBtn.addEventListener('click', strongAttackHandler);